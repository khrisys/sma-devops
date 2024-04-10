#!/bin/bash -x
set -e
echo "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"
psql --username "pguser" --dbname "postgres" --port 5432 <<-EOSQL
create table public.rogero (id int);

su postgres -c "createuser -w -d -r -s pguser"
su postgres -c "createdb -O toto pguser"

#CREATE ROLE pguser WITH LOGIN;
#GRANT CONNECT, SELECT ON DATABASE toto TO pguser;
#GRANT pguser TO pguser;

EOSQL
echo "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"
