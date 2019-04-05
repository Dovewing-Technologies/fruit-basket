echo "Waiting for Vault..."
#docker-entrypoint.sh server -dev &
while [ "$(curl -XGET --insecure --silent -H "X-Vault-Token: $VAULT_TOKEN" $VAULT_ADDR/v1/sys/health | jq '.initialized')" != "true" ] 
do
	echo 'Vault is Initializing...'
	sleep 2
done

echo "Vault Started."

echo "Authenticate into Vault"
# Authenticate to Vault
vault login $VAULT_TOKEN

echo "Adding secrets to Vault..."
vault kv put secret/fruit-basket mysql.username=$MYSQL_USERNAME mysql.password=$MYSQL_PASSWORD mysql.url=$MYSQL_URL

#while [ "$(curl -XGET --insecure --silent -H "X-Vault-Token: $VAULT_DEV_ROOT_TOKEN_ID" http://localhost:8200/v1/sys/health | jq '.initialized')" == "true" ] 
#do
#	sleep 2
#done