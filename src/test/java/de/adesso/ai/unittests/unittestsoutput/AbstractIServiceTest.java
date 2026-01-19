package de.adesso.ai.unittests.unittestsoutput;

import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;


public abstract class AbstractIServiceTest {

    protected abstract IService service();

    @Test
    void OKTest() {
        assertSoftly(sa -> {
            sa.assertThat(service().add(1, 3)).isEqualTo(4);
            sa.assertThat(service().add(of("1"), of("3"))).isEqualTo(of("1", "3"));
            sa.assertThatThrownBy(() -> service().error("message"))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("message");
        });
    }

    @Test
    void errorAssertJ() {
        assertSoftly(sa -> {
            sa.assertThat(service().add(1, 3)).isEqualTo(6);
            sa.assertThat(service().add(of("1"), of("3"))).isEqualTo(of("1", "5"));
            sa.assertThatThrownBy(() -> service().error("message"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("message");
            sa.assertThatThrownBy(() -> service().error("message"))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("another message");
        });
    }

    @Test
    void errorJUnit() {
        assertAll(
                () -> assertEquals(6, service().add(1, 3)),
                () -> assertEquals(of("1", "5"), service().add(of("1"), of("3"))),
                () -> assertThrows(IllegalArgumentException.class, () -> service().error("message")),
                () -> {
                    var ex = assertThrows(IllegalStateException.class, () -> service().error("another message"));
                    assertEquals("message", ex.getMessage());
                }
        );
    }
}
