module.exports = function(grunt) {

  grunt.initConfig({
    run_java: {
      options: {
        stdout: false,
        stderr: false,
        stdin: false,
        failOnError: true
      },
      jar_task: {
        execOptions: {
          cwd: "."
        },
        command: "jar cfm build.jar Manifest.txt -C bin/ .",
        jarName: "",
        jarOptions: "",
        dir: "",
      }
    }
  });

  grunt.loadNpmTasks('grunt-run-java');

  grunt.registerTask('default', ['run_java']);
};
