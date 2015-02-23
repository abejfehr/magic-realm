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
    },
    mkdir: {
      pdfbuild: {
        options: {
          mode: 0777,
          create: ['pdfbuild']
        }
      },
    },
    copy: {
      pdfbuild: {
        expand: true,
        cwd: '.',
        src: 'src/com/magicrealm/**',
        dest: 'pdfbuild/',
        flatten: true,
        filter: 'isFile',
        rename: function(dest, src) {
          return dest + src.replace(/\.java$/, ".md");
        }
      },
    },
    indent: {
      pdfbuild: {
        src: ['pdfbuild/*.md'],
        dest: 'pdfbuild/'
      },
      options: {
        style: 'space',
        size: 4,
        change: 1
      }
    },
    usebanner: {
      taskName: {
        options: {
          position: 'top',
          process: function ( filepath ) {
            return grunt.template.process(
              '<%= filename %>\n===\n',
              {
                data: {
                  filename: (filepath.match(/\/([^/]*)$/)[1]).replace(".md", ".java")
                }
              }
            );
          },
          linebreak: true
        },
        files: {
          src: [ 'pdfbuild/*.md' ]
        }
      }
    },
    concat: {
      dist: {
        src: ['pdfbuild/*.md'],
        dest: 'pdfbuild/sourceTeam17.md',
      },
    },
    markdownpdf: {
      options: {},
      pdfbuild: {
        src: "pdfbuild/sourceTeam17.md",
        dest: "Team17Iteration1/"
      }
    },
    clean: {
      pdfbuild: ["pdfbuild/*"]
    }
  });

  grunt.loadNpmTasks('grunt-run-java');

  /**
   * This is a multi-step thing, we're going to put all of the code in a giant pdf file.
   * 1. Make a directory called pdfbuild
   * 2. Copy all of the code files to that directory
   * 3. Rename the extensions of all Java files to Markdown
   * 4. Indent all the contents of each file by 4 spaces
   * 5. Add a title to the top of each file
   * 6. Concatenate all the files into one markdown file
   * 7. Convert the massive file into pdf
   * 8. Delete pdfbuild folder
   */

  grunt.loadNpmTasks('grunt-mkdir');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-indent');
  grunt.loadNpmTasks('grunt-banner');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-markdown-pdf');
  grunt.loadNpmTasks('grunt-contrib-clean');


  grunt.registerTask('default', [
    'mkdir', 'run_java', 'copy', 'indent', 'usebanner', 'concat', 'markdownpdf', 'clean'
    ]);
};
