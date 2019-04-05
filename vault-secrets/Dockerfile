FROM vault

# Install Curl
RUN apk add --no-cache curl

# Instal jq
ADD https://github.com/stedolan/jq/releases/download/jq-1.6/jq-linux64 /usr/bin/jq
RUN chmod 755 /usr/bin/jq

ENV MYSQL_URL default
ENV MYSQL_USERNAME default
ENV MYSQL_PASSWORD default
ENV VAULT_DEV_ROOT_TOKEN_ID 0000

EXPOSE 8200
ADD vault-init.sh /

RUN chmod 755 vault-init.sh

ENTRYPOINT exec "./vault-init.sh"