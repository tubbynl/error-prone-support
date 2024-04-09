package tech.picnic.errorprone.workshop.refasterrules;

import com.google.common.base.Preconditions;
import com.google.errorprone.refaster.ImportPolicy;
import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;
import com.google.errorprone.refaster.annotation.UseImportPolicy;

import static com.google.common.base.Preconditions.checkArgument;


/** Refaster rules for the third assignment of the workshop. */
@SuppressWarnings("UnusedTypeParameter" /* Ignore this for demo purposes. */)
final class WorkshopAssignment3Rules {
  private WorkshopAssignment3Rules() {}

  // XXX: Tip: check the input and output files to see the *expected* refactoring.

  /** Prefer {@link Preconditions#checkArgument(boolean)} over if statements. */
  static final class CheckArgumentWithoutMessage {
    @BeforeTemplate
    void before(String input) {
      if (!input.isEmpty()) {
        throw new IllegalArgumentException();
      }
    }

    @AfterTemplate
    @UseImportPolicy(ImportPolicy.STATIC_IMPORT_ALWAYS)
    void after(String input) {
      checkArgument(input.isEmpty());
    }

    // XXX: Implement the Refaster rule to get the test green.
  }

  /** Prefer {@link Preconditions#checkArgument(boolean, Object)} over if statements. */
  static final class CheckArgumentWithMessage {
    @BeforeTemplate
    void before(String input, String message) {
      if (!input.isEmpty()) {
        throw new IllegalArgumentException(message);
      }
    }

    @AfterTemplate
    @UseImportPolicy(ImportPolicy.STATIC_IMPORT_ALWAYS)
    void after(String input, String message) {
      checkArgument(input.isEmpty(), message);
    }
  }
}
