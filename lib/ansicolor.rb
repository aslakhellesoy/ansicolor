require 'ansicolor-1.0.jar'
include_class 'ansicolor.ANSIColorOutputStream'
include_class 'org.jruby.RubyIO'
out = ENV['ANSI_DEBUG'] ? ANSIColorOutputStream.debugifyStdout : ANSIColorOutputStream.ansifyStdout
JRuby.runtime.getGlobalVariables.set("$stdout", RubyIO.new(JRuby.runtime, out))
