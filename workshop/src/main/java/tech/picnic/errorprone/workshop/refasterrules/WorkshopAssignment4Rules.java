package tech.picnic.errorprone.workshop.refasterrules;

import com.google.errorprone.refaster.Refaster;
import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.AlsoNegation;
import com.google.errorprone.refaster.annotation.BeforeTemplate;
import com.google.errorprone.refaster.annotation.NoAutoboxing;

import java.util.Objects;

/** Refaster rules for the fourth assignment of the workshop. */
@SuppressWarnings("java:S1698" /* Reference comparison is valid for enums. */)
final class WorkshopAssignment4Rules {
  private WorkshopAssignment4Rules() {}

  // The test fails because non Enum comparisons are also rewritten.
  // Fix the test by tweaking the type parameters.

  // XXX: Get the test to pass by improving the Refaster rule (uncommented it first).

    static final class PrimitiveOrReferenceEqualityEnum<T> {
      @BeforeTemplate
      boolean before0(T a, T b) {
        return a.equals(b);
      }

      @BeforeTemplate
      boolean before2(T a, T b) {
        return Objects.equals(a, b);
      }

      @AfterTemplate
      @AlsoNegation
      boolean after(T a, T b) {
        return a == b;
      }
    }
}
