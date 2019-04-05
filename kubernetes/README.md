## Kubernetes Cluster Deployment

This documentation is rudimentary and does not provide a complete "quickstart" style guide to deploying the app on kubernetes. However I do plan on improving the documentation to provide such an artifact.

The next step to containerzing your spring boot app and running it locally (using docker compose or the like) would be to deploy it on a cluster with multiple replicas. I chose to do a Kubernetes managed cluster on GCP to demonstrate this. If you want to read the basics of this service called [Kubernetes Engine](https://cloud.google.com/kubernetes-engine/docs/), please do so.

This repo has a single deployment manifest that creates all the Kubernetes objects necessary to deploy the app to the cluster. Additionally you'll need a deployment template for the secrets that is used by the primary deployment template. The yml necessary for creating the kubernetes secrets object is below - be sure to substitute the `<value>` items. Optionally you can also include this secret object within the [fruitbasket-kubernetes.yml](fruitbasket-kubernetes.yml).

```yml
apiVersion: v1
kind: Secret
metadata:
  name: fruitbasket-secrets
type: Opaque
data:
  mysql-username: <value>
  mysql-password: <value>
  mysql-url: <value>
  vault-token: <value>
```
