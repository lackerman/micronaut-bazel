load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "bookmarks",
    srcs = glob([
        "*.java",
    ]),
    visibility = [
        "//micronaut_server/src/main/java:__subpackages__",
        "//micronaut_server/src/test/java:__subpackages__",
    ],
    deps = [
        "//:lombok_lib",
        "//:micronaut_annotation_lib",
        "@maven//:javax_annotation_javax_annotation_api",
        "@maven//:javax_inject_javax_inject",
    ],
)
