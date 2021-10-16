## Ktor demo application

Demo project that shows how to develop a microservice in Ktor, which is deployed to Gcloud Run with:

* Ktor+jetty: Http server written in Kotlin.

* [Jib](https://github.com/GoogleContainerTools/jib): Creates a docker container with entry point to main class.

* Gcloud Build for CI/CD and Gcloud Run for deployment and it auto scales.

* detekt: Static analysis tool.

### Google Build: cloudbuild.yml


