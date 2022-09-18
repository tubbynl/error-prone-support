package tech.picnic.errorprone.refastertemplates;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.assertj.core.api.AbstractComparableAssert;
import tech.picnic.errorprone.refaster.test.RefasterTemplateTestCase;

final class AssertJComparableTemplatesTest implements RefasterTemplateTestCase {
  AbstractComparableAssert<?, ?> testAssertThatIsEqualByComparingTo() {
    return assertThat(BigDecimal.ZERO.compareTo(BigDecimal.ONE)).isEqualTo(0);
  }

  AbstractComparableAssert<?, ?> testAssertThatIsNotEqualByComparingTo() {
    return assertThat(BigDecimal.ZERO.compareTo(BigDecimal.ONE)).isNotEqualTo(0);
  }

  AbstractComparableAssert<?, ?> testAssertThatIsLessThan() {
    return assertThat(BigDecimal.ZERO.compareTo(BigDecimal.ONE)).isNegative();
  }

  AbstractComparableAssert<?, ?> testAssertThatIsLessThanOrEqualTo() {
    return assertThat(BigDecimal.ZERO.compareTo(BigDecimal.ONE)).isNotPositive();
  }

  AbstractComparableAssert<?, ?> testAssertThatIsGreaterThan() {
    return assertThat(BigDecimal.ZERO.compareTo(BigDecimal.ONE)).isPositive();
  }

  AbstractComparableAssert<?, ?> testAssertThatIsGreaterThanOrEqualTo() {
    return assertThat(BigDecimal.ZERO.compareTo(BigDecimal.ONE)).isNotNegative();
  }
}
