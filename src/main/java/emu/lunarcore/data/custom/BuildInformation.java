package emu.lunarcore.data.custom;

import java.util.List;

import lombok.Getter;

@Getter
public class BuildInformation {
    private int avatarId;
    private String avatarName;
    private String fullName;
    private int eidolon;
    private int skill;
    private List<BuildDetail> buildList;

    @Getter
    public static class BuildDetail {
        private String buildName;
        private EquipmentDetail equipment;
        private List<RelicDetail> relicList;
    }

    @Getter
    public static class EquipmentDetail {
        private int tid;
        private int imposition;
    }

    @Getter
    public static class RelicDetail {
        private int tid;
        private int type;
        private int mainAffixId;
        private List<RelicSubAffix> subAffixList;
    }

    @Getter
    public static class RelicSubAffix {
        private int affixId;
        private int cnt;
    }
}
