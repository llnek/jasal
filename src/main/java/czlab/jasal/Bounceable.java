/**
 * Copyright (c) 2013-2017, Kenneth Leung. All rights reserved.
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 */

package czlab.jasal;

import java.util.Optional;

/**
 * @author Kenneth Leung
 */
public class Bounceable<T> {

  /**
   */
  public Optional<Bounceable<T>> next() {
    return Optional.empty();
  }

  /**
   */
  public T value() {
    throw new RuntimeException("Not implemented");
  }

  /**
   */
  public final T run() {
    Bounceable<T> b = this;

    while (b.next().isPresent()) {
      b = b.next().get();
    }

    return b.value();
  }

}


class FacDemo {

  public static Bounceable<Integer> create(final int n, final int acc) {
    if (n < 1) {
      return new Bounceable<Integer>() {
        public Integer value() { return acc; }
      };
    }
    return new Bounceable<Integer>() {
      public Optional<Bounceable<Integer>> next() {
        return Optional.of(create(n - 1, acc * n));
      }
    };
  }
}

//FacDemo.create(4, 1).run();




