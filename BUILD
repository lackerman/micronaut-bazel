load("@com_github_bazelbuild_buildtools//buildifier:def.bzl", "buildifier")
load("@rules_java//java:defs.bzl", "java_library", "java_plugin")

java_plugin(
    name = "lombok_plugin",
    processor_class = "lombok.launch.AnnotationProcessorHider$AnnotationProcessor",
    deps = [
        "@maven//:org_projectlombok_lombok",
    ],
)

java_library(
    name = "lombok_lib",
    exported_plugins = ["lombok_plugin"],
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:org_projectlombok_lombok",
    ],
)

java_plugin(
    name = "typeelementvisitorprocessor",
    processor_class = "io.micronaut.annotation.processing.TypeElementVisitorProcessor",
    deps = [
        "@maven//:io_micronaut_micronaut_aop",
        "@maven//:io_micronaut_micronaut_inject",
        "@maven//:io_micronaut_micronaut_inject_java",
        "@maven//:io_micronaut_micronaut_validation",
    ],
)

java_plugin(
    name = "beandefinitioninjectprocessor",
    processor_class = "io.micronaut.annotation.processing.BeanDefinitionInjectProcessor",
    deps = [
        "@maven//:io_micronaut_micronaut_aop",
        "@maven//:io_micronaut_micronaut_inject",
        "@maven//:io_micronaut_micronaut_inject_java",
        "@maven//:io_micronaut_micronaut_validation",
    ],
)

java_plugin(
    name = "servicedescriptionprocessor",
    processor_class = "io.micronaut.annotation.processing.ServiceDescriptionProcessor",
    deps = [
        "@maven//:io_micronaut_micronaut_aop",
        "@maven//:io_micronaut_micronaut_inject",
        "@maven//:io_micronaut_micronaut_inject_java",
        "@maven//:io_micronaut_micronaut_validation",
    ],
)

java_library(
    name = "micronaut_annotation_lib",
    exported_plugins = [
        "typeelementvisitorprocessor",
        "beandefinitioninjectprocessor",
        "servicedescriptionprocessor",
    ],
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:io_micronaut_micronaut_aop",
        "@maven//:io_micronaut_micronaut_inject",
        "@maven//:io_micronaut_micronaut_inject_java",
        "@maven//:io_micronaut_micronaut_validation",
    ],
)

buildifier(
    name = "buildifier",
)
