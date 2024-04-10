# generation du package
FROM node:latest as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app
#CMD["RUN", "npm", "install"]
#CMD["RUN", "npm", "run", "build"]
RUN npm install
RUN npm run build


# construction du conteneur
FROM nginx:latest
COPY --from=build /usr/local/app/dist/application-frontend/browser /usr/share/nginx/html
EXPOSE 80

