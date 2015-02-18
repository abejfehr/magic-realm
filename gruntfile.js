module.exports = function(grunt) {

  grunt.initConfig({
//    pkg: grunt.file.readJSON('package.json'),
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
        command: "jar",
        jarName: "build.jar",
        jarOptions: "cfm",
        manifestName: "MANIFEST.MF",
        dir: "",
        files: "src/"
      }
    }
  });

  grunt.loadNpmTasks('grunt-run-java');

  grunt.registerTask('default', ['run_java']);
};
