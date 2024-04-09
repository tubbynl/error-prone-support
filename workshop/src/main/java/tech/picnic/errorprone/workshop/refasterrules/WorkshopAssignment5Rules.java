package tech.picnic.errorprone.workshop.refasterrules;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;

import java.util.stream.Stream;

/** Refaster rules for the fifth assignment of the workshop. */
@SuppressWarnings("UnusedTypeParameter" /* Ignore this for demo purposes. */)
final class WorkshopAssignment5Rules {
  private WorkshopAssignment5Rules() {}

  abstract static class StreamDoAllMatch<T> {

    @BeforeTemplate
    boolean input(String string) {
      return Stream.of(string).noneMatch(s -> !s.isBlank());
    }

    @AfterTemplate
    boolean output(String string) {
      return Stream.of(string).noneMatch(String::isBlank);
    }

    // XXX: Implement the Refaster rule to get the test green.
    // Tip: use the `@Placeholder` annotation.
  }
}
