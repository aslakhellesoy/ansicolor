require 'rubygems'
require 'term/ansicolor'
include Term::ANSIColor

if defined?(JRUBY_VERSION)
  $:.unshift(File.dirname(__FILE__) + '/lib')
  $:.unshift(File.dirname(__FILE__) + '/target')
  require 'ansicolor'
else
  require 'Win32/Console/ANSI'
end

print bold, red, "red bold", reset, "\n"
print clear, red, "red regular", reset, "\n"
