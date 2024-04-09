package tech.picnic.errorprone.workshop.refasterrules;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;

import java.util.Collections;
import java.util.List;

/** Refaster rules for the second assignment of the workshop. */
@SuppressWarnings("UnusedTypeParameter" /* Ignore this for demo purposes. */)
final class WorkshopAssignment2Rules {
  private WorkshopAssignment2Rules() {}

  /**
   * Prefer {@link ImmutableList#of(Object)} over alternatives that don't communicate the
   * immutability of the resulting list at the type level.
   */
  static final class ImmutableListOfOne<T> {

    @BeforeTemplate
    List<T> before(T input) {
      return Collections.singletonList(input);
    }

    @BeforeTemplate
    List<T> before1(T input) {
      return List.of(input);
    }

    @AfterTemplate
    List<T> after(T input) {
      return ImmutableList.of(input);
    }

    // XXX: Implement this Refaster rule.
  }
}
