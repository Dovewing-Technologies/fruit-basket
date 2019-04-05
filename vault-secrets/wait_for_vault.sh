set -e

VAULT_TOKEN="$1"
shift
cmd="$@"

echo 'Vault is Initializing...'
while [ "$(curl -XGET --insecure --silent -H "X-Vault-Token: $VAULT_TOKEN" http://localhost:8200/v1/sys/health | jq '.initialized')" != "true" ] 
do
	echo 'Vault is Initializing...'
	sleep 2
done
>&2 echo "Vault is up - executing command"
exec $cmd