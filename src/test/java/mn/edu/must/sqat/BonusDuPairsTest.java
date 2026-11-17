package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusDuPairsTest {
    @Test
    @DisplayName("du_emptyAttendance covers loop false and score paths")
    void emptyAttendance() {
        assertEquals(5, DataFlowTargets.bonus(new int[0], 0));
        assertEquals(0, DataFlowTargets.bonus(new int[0], 1));
    }

    @Test
    @DisplayName("du_absenceKillsStreakDef46")
    void absenceResetsStreak() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {1, 1, 0, 1, 1, 1}, 0));
    }

    @Test
    @DisplayName("du_fiveConsecutiveDaysSetsBest44")
    void fiveConsecutiveDays() {
        assertEquals(8, DataFlowTargets.bonus(new int[] {1, 1, 1, 1, 1}, 0));
    }

    @Test
    @DisplayName("du_presentExceedsBestKillsWrongVariableMutation")
    void presentCanExceedBest() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {1, 0, 1, 0, 1, 0, 1, 0, 1}, 5));
    }

    @Test
    @DisplayName("du_initialScoreFlowsToAdditionWhenOnlyStreakQualifies")
    void initialScoreFlowsToStreakBonus() {
        assertEquals(3, DataFlowTargets.bonus(new int[] {1, 1, 1, 1, 1}, 6));
    }

    @Test
    @DisplayName("du_thresholdEqualityAndZeroThreshold")
    void thresholdBoundaries() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {1, 0}, 1));
        assertEquals(5, DataFlowTargets.bonus(new int[] {0}, 0));
    }

    @Test
    @DisplayName("du_longRunAndTrailingAbsence")
    void longRunThenAbsence() {
        assertEquals(8, DataFlowTargets.bonus(new int[] {1, 1, 1, 1, 1, 1, 0}, 4));
    }

    @Test
    @DisplayName("du_rejectsNullAndNegativeThreshold")
    void invalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 0));
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[0], -1));
    }
}
