# Declares that this directory is the root of a Bazel workspace.
# See https://docs.bazel.build/versions/master/build-ref.html#workspace
workspace(
    # How this workspace would be referenced with absolute labels from another workspace
    name = "micronaut_bazel",
)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

RULES_JVM_EXTERNAL_TAG = "3.3"

RULES_JVM_EXTERNAL_SHA = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "2d536797707dd1697441876b2e862c58839f975c8fc2f0f96636cbd428f45866",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_go/releases/download/v0.23.5/rules_go-v0.23.5.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.23.5/rules_go-v0.23.5.tar.gz",
    ],
)

http_archive(
    name = "bazel_gazelle",
    sha256 = "cdb02a887a7187ea4d5a27452311a75ed8637379a1287d8eeb952138ea485f7d",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-gazelle/releases/download/v0.21.1/bazel-gazelle-v0.21.1.tar.gz",
        "https://github.com/bazelbuild/bazel-gazelle/releases/download/v0.21.1/bazel-gazelle-v0.21.1.tar.gz",
    ],
)

http_archive(
    name = "com_google_protobuf",
    sha256 = "9748c0d90e54ea09e5e75fb7fac16edce15d2028d4356f32211cfa3c0e956564",
    strip_prefix = "protobuf-3.11.4",
    urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.11.4.zip"],
)

http_archive(
    name = "com_github_bazelbuild_buildtools",
    sha256 = "3053622b690444219d739c832293c82296d85626682ef4bbe45ebba3fb9f5db1",
    strip_prefix = "buildtools-master",
    url = "https://github.com/bazelbuild/buildtools/archive/master.zip",
)

#######################################
# Java dependencies
#######################################

load("@rules_jvm_external//:defs.bzl", "maven_install")

MICRONAUT_VER = "2.0.0"

maven_install(
    artifacts = [
        # Micronaut dependencies
        "io.micronaut:micronaut-aop:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-core:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-http:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-http-client:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-http-server-netty:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-inject:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-inject-java:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-runtime:%s" % MICRONAUT_VER,
        "io.micronaut:micronaut-validation:%s" % MICRONAUT_VER,
        "com.github.spotbugs:spotbugs-annotations:4.0.6",
        # Micronaut Testing dependencies
        "io.micronaut.test:micronaut-test-junit5:1.2.0",
        "io.micronaut.test:micronaut-test-core:1.2.0",
        # Logging dependencies
        "ch.qos.logback:logback-classic:1.2.3",
        # Lombok dependencies
        "org.projectlombok:lombok:1.18.12",
    ],
    fail_on_missing_checksum = True,
    fetch_sources = True,
    maven_install_json = "@micronaut_bazel//:maven_install.json",
    repositories = [
        "https://jcenter.bintray.com/",
    ],
    resolve_timeout = 3600,
    version_conflict_policy = "pinned",
)

# Lock/pin the Maven dependencies for reproducible builds.
load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

#######################################
# GO SUPPORT
#######################################

# buildifier is written in Go and hence needs rules_go to be built.
# See https://github.com/bazelbuild/rules_go for the up to date setup instructions.

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")

gazelle_dependencies()

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

#######################################
# UTILITIES
#######################################

load("@com_github_bazelbuild_buildtools//buildifier:deps.bzl", "buildifier_dependencies")

buildifier_dependencies()
