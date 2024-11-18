/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright © 2013-2024, Kenneth Leung. All rights reserved. */

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




