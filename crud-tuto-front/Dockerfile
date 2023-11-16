# Use an LTS version of Node.js as the base image
FROM node:lts as node

WORKDIR /app

COPY . .

RUN npm config set fetch-retry-mintimeout 20000
RUN npm config set fetch-retry-maxtimeout 120000
RUN npm install
RUN npm run build


FROM nginx:alpine


COPY --from=node /app/dist/crudtuto-Front /usr/share/nginx/html
