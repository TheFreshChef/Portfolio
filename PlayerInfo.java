/**
 * @author Anish, Edric, Satvik
 * @version Final Version
 */
public record PlayerInfo(String name, String tName, String region, String agent, double acs, double kd, double adr) {
    /**
     * Compares the name of the 2 players
     * @param other other player
     * @return 1 or 0 depending if the name matches or not
     */
    public int compareName(PlayerInfo other) {
        if (name.equals(other.name())) {
            return 1;
        }
        return 0;
    }

    /**
     * Returns count
     * @param count guess
     * @return Returns a number which is used in Statdisplayer to determine if the count it valid
     */
    public int validCount(int count) {
        if(count == 1 || count == 2 || count == 3 || count == 4 || count == 5 || count == 6) {
            return 1;
        }
        return 0;
    }

    /**
     * Compares the team name of the 2 players
     * @param other other player
     * @return 1 or 0 depending if the team name matches or not
     */
    public int compareTName(PlayerInfo other) {
        if (tName.equals(other.tName())) {
            return 0;
        }
        return 1;
    }

    /**
     * Compares the region of the 2 players
     * @param other other player
     * @return 1 or 0 depending if the region matches or not
     */
    public int compareRegion(PlayerInfo other) {
        if (region.equals(other.region())) {
            return 0;
        }
        return 1;
    }

    /**
     * Compares the agent of the 2 players
     * @param other other player
     * @return 1 or 0 depending if the agent matches or not
     */
    public int compareAgent(PlayerInfo other) {
        if (agent.equals(other.agent())) {
            return 0;
        }
        return 1;
    }

    /**
     * Compares the Average Combat Score of the 2 players
     * @param other other player
     * @return 0, 1, 2, 3 depending on if the ACS matches, is within a range, or is far off from the other player
     */
    public int compareACS(PlayerInfo other) {
        if (acs == other.acs()) {
            return 0;
        }
        if ((acs - other.acs()) < 20) {
            return 1;
        }
        if ((other.acs() - acs) < 20) {
            return 2;
        }
        return 3;
    }

    /**
     * Compares the Kill Death Ratio of the 2 players
     * @param other other player
     * @return 0, 1, 2, 3 depending on if the KD matches, is within a range, or is far off from the other player
     */
    public int compareKD(PlayerInfo other) {
        if (kd == other.kd()) {
            return 0;
        }
        if ((kd - other.kd()) < 0.25) {
            return 1;
        }
        if ((other.kd() - kd) < 0.25) {
            return 2;
        }
        return 3;
    }

    /**
     * Compares the Average Damage per Round of the 2 players
     * @param other other player
     * @return 0, 1, 2, 3 depending on if the ADR matches, is within a range, or is far off from the other player
     */
    public int compareADR(PlayerInfo other) {
        if (adr == other.adr()) {
            return 0;
        }
        if ((adr - other.adr()) < 15) {
            return 1;
        }
        if ((other.adr() - adr) < 15) {
            return 2;
        }
        return 3;
    }
}
