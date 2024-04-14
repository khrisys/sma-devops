# generation du package
FROM node:21-alpine as build
WORKDIR /usr/local/app
#RUN npm cache clean --force
COPY ./ /usr/local/app
#CMD["RUN", "npm", "ng", "install"]
#CMD["RUN", "npm", "ng, build"]
RUN npm install
RUN npm run build


# construction du conteneur
FROM nginx:latest
COPY --from=build /usr/local/app/dist/angular-module-frontend/browser /usr/share/nginx/html
COPY ./nginx.conf  /etc/nginx/conf.d/default.conf
EXPOSE 80
