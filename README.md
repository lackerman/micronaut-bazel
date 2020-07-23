# Micronaut 2.0.0 with Bazel

Run the micronaut server
```shell script
bazel run //micronaut_server/src/main/java/me/a6n/bookmarker/micronaut:micronaut_app
```

Micronaut and bazel seem to place nice on `v1.3.7` but not on `v2.0.0`

You can run v1.3.7 by checking out branch `micronaut-v1.3.7`

Built using Bazel version 3.4.1 on macOS
