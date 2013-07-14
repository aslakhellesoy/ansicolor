require 'ansicolor-1.0.jar'
java_import 'ansicolor.ANSIColorOutputStream'
java_import 'org.jruby.RubyIO'
out = ENV['ANSI_DEBUG'] ? ANSIColorOutputStream.debugifyStdout : ANSIColorOutputStream.ansifyStdout
JRuby.runtime.getGlobalVariables.set("$stdout", RubyIO.new(JRuby.runtime, out))
