package JavaAdvanced.AdvancedExams.E22Feb2020.guild;

import java.util.LinkedHashMap;
import java.util.Map;

public class Guild {
    private Map<String, Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        if (count() < capacity) {
            this.roster.putIfAbsent(player.getName(), player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.remove(name, roster.get(name));
    }

    public void promotePlayer(String name) {
        if (!this.roster.get(name).getRank().equals("Member")) {
            this.roster.get(name).setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        if (!this.roster.get(name).getRank().equals("Trial")) {
            this.roster.get(name).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removedPlayers = this.roster.values().stream()
                .filter(player -> clazz.equals(player.getClazz()))
                .toArray(Player[]::new);

        for (Player player : removedPlayers) {
            this.roster.remove(player.getName());
        }
        return removedPlayers;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(":\n");
        this.roster.forEach((key, value) -> {
            sb.append(value).append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}

