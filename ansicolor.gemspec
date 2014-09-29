Gem::Specification.new do |s|
  s.name = %q{ansicolor}
  s.version = "1.1"
  s.platform = %q{java}

  s.specification_version = 2 if s.respond_to? :specification_version=

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.authors = ["Aslak Hellesøy", "David Pershouse"]
  s.date = %q{2014-09-29}
  s.description = %q{ANSI color support for Java/JRuby on Windows.}
  s.summary = %q{ANSI color support for Java/JRuby on Windows.}
  s.email = %q{aslak.hellesoy@gmail.com}
  s.has_rdoc = false
  s.files = ["lib/ansicolor.rb", "lib/ansicolor-1.1.jar", "History.txt"]
  s.homepage = %q{http://wiki.github.com/aslakhellesoy/ansicolor}
  s.require_paths = ["lib"]
  s.required_ruby_version = Gem::Requirement.new(">= 1.8.4")
  s.rubygems_version = %q{1.3.1}
end
