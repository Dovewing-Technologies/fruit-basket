# Entrypoint Script for Fruit basket app

# Wait for secrets to be loaded into Vault before starting app
echo "Waiting for vault secrets to be loaded..."
until $(curl --header "X-Vault-Token: $VAULT_TOKEN" $VAULT_ADDR/v1/secret/data/fruit-basket | grep -q 'mysql.url'); do
	echo "Still waiting for vault secrets to be loaded..."
	sleep 2
done

echo "Secrets loaded to vault."
echo "Starting fruit basket app.."
java -jar /codeninja-fruit-basket.jar
