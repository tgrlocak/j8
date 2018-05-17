package com.tgrl.exp.j8.functional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import com.tgrl.exp.j8.model.Dragon;
import com.tgrl.exp.j8.model.DragonDistance;
import com.tgrl.exp.j8.model.Location;

/**
 * <p>
 * With the increasing popularity of multi-core processors, concurrent programming has become more
 * important. Functional programming forms a solid basis for concurrent programming and Java 8
 * supports concurrency in many different ways.
 * </p>
 * 
 * <p>
 * One of those ways is the <code>parallelStream()</code> method on Collection. It provides a very
 * quick way to use a Stream concurrently. However, like all optimizations, you should test to make
 * sure that your code is actually faster, and it should be used sparingly. Too much concurrency
 * could actually cause your application to slow down.
 * </p>
 * 
 * <p>
 * Another way Java 8 supports concurrency is with the new <code>CompletableFuture</code> class. It
 * has the <code>supplyAsync</code> static method that takes in the functional interface
 * <code>Supplier</code>. It also has the method <code>thenAccept</code> which takes in
 * <code> Consumer</code> that handles completion of the task. The CompletableFuture calls on the
 * given supplier in a different thread and executes the consumer when complete.
 * </p>
 * 
 * <p>
 * When used in conjunction with things like the <code>CountDownLatch</code>,
 * <code>AtomicInteger</code>, <code>AtomicLong</code>, <code>AtomicReference</code>, … you can
 * implement thread-safe, concurrent FP-like code
 * </p>
 * 
 * @author tugrul.ocak
 *
 */
public class ConcurrencyIn8 {

  /**
   * This example finds the closest dragon to a certain <code>Location</code> (assume that
   * <code>Dragon</code>’s <code>distance</code> method involves a time-consuming calculation)
   */
  public Dragon closestDragon(Location location) {
    List<Dragon> dragons = Dragon.getDragons();

    AtomicReference<DragonDistance> closest = new AtomicReference<>(DragonDistance.worstMatch());
    CountDownLatch latch = new CountDownLatch(dragons.size());

    dragons.forEach(dragon -> {
      CompletableFuture.supplyAsync(() -> dragon.distance(location)).thenAccept(result -> {
        closest.accumulateAndGet(result, DragonDistance::closest);
        latch.countDown();
      });
    });

    try {
      latch.await();
    } catch (InterruptedException e) {
      throw new RuntimeException("Interrupted during calculations", e);
    }

    return closest.get().getDragon();
  }

  /**
   * The above example could be simplified using the parallelStream() default method (since only one
   * type of calculation is going on) in the following way
   */
  public Dragon closestDragonAnotherWay(Location location) {
    List<Dragon> dragons = Dragon.getDragons();

    // This performs essentially the same task as the previous example but in a more concise (and
    // functional) way.
    return dragons.parallelStream().map(dragon -> dragon.distance(location))
        .reduce(DragonDistance.worstMatch(), DragonDistance::closest).getDragon();
  }
}
