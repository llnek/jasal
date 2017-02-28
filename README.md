# jasal

[![Build Status](https://travis-ci.org/llnek/jasal.svg?branch=master)](https://travis-ci.org/llnek/jasal)

A set of useful java classes (mainly interfaces) used by my other
projects, such as `project wabbit`.

## Installation

Add the following dependency to your `project.clj` file:

    [io.czlab/jasal "1.0.0"]

## Usage

Simply import the wanted classes into your clojure code, for example:

```clojure
(ns demo.core
  (:import [czlab.jasal CU]))

(defn shuffleInput 
  ^String
  [^String someString]
  (CU/shuffle someString))

```

## Contacting me / contributions

Please use the project's [GitHub issues page] for all questions, ideas, etc. **Pull requests welcome**. See the project's [GitHub contributors page] for a list of contributors.

## License

Copyright © 2013-2017 Kenneth Leung

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

<!--- links -->
[1]: http://ant.apache.org/
<!--- links (repos) -->
[CHANGELOG]: https://github.com/llnek/jasal/releases
[GitHub issues page]: https://github.com/llnek/jasal/issues
[GitHub contributors page]: https://github.com/llnek/jasal/graphs/contributors


