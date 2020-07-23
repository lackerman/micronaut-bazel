load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "micronaut_lib",
    srcs = glob([
        "*.java",
    ]),
    visibility = [
        "//micronaut_server/src/test:__subpackages__",
    ],
    deps = [
        "//micronaut_server/src/main/java/me/a6n/bookmarker/bookmarks",
        "//:lombok_lib",
        "//:micronaut_annotation_lib",
        "@maven//:io_micronaut_micronaut_core",
        "@maven//:io_micronaut_micronaut_http",
        "@maven//:io_micronaut_micronaut_http_client",
        "@maven//:io_micronaut_micronaut_http_server_netty",
        "@maven//:io_micronaut_micronaut_runtime",
        "@maven//:javax_annotation_javax_annotation_api",
        "@maven//:javax_inject_javax_inject",
    ],
)

java_binary(
    name = "micronaut_app",
    main_class = "me.a6n.bookmarker.micronaut.App",
    resource_strip_prefix = "micronaut_server/src/main/resources",
    resources = [
        "//micronaut_server/src/main/resources",
    ],
    visibility = [
        "//visibility:public",
    ],
    runtime_deps = [
        ":micronaut_lib",
        "@maven//:ch_qos_logback_logback_classic",
    ],
)
