// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import us.hebi.quickbuf.ProtoEnum;
import us.hebi.quickbuf.ProtoUtil;

public final class SceneCastSkillOuterClass {
  /**
   * Protobuf enum {@code SceneCastSkill}
   */
  public enum SceneCastSkill implements ProtoEnum<SceneCastSkill> {
    /**
     * <code>SCENE_CAST_SKILL_NONE = 0;</code>
     */
    SCENE_CAST_SKILL_NONE("SCENE_CAST_SKILL_NONE", 0),

    /**
     * <code>SCENE_CAST_SKILL_PROJECTILE_HIT = 1;</code>
     */
    SCENE_CAST_SKILL_PROJECTILE_HIT("SCENE_CAST_SKILL_PROJECTILE_HIT", 1),

    /**
     * <code>SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH = 2;</code>
     */
    SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH("SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH", 2);

    /**
     * <code>SCENE_CAST_SKILL_NONE = 0;</code>
     */
    public static final int SCENE_CAST_SKILL_NONE_VALUE = 0;

    /**
     * <code>SCENE_CAST_SKILL_PROJECTILE_HIT = 1;</code>
     */
    public static final int SCENE_CAST_SKILL_PROJECTILE_HIT_VALUE = 1;

    /**
     * <code>SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH = 2;</code>
     */
    public static final int SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH_VALUE = 2;

    private final String name;

    private final int number;

    private SceneCastSkill(String name, int number) {
      this.name = name;
      this.number = number;
    }

    /**
     * @return the string representation of enum entry
     */
    @Override
    public String getName() {
      return name;
    }

    /**
     * @return the numeric wire value of this enum entry
     */
    @Override
    public int getNumber() {
      return number;
    }

    /**
     * @return a converter that maps between this enum's numeric and text representations
     */
    public static EnumConverter<SceneCastSkill> converter() {
      return SceneCastSkillConverter.INSTANCE;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value, or null if unknown.
     */
    public static SceneCastSkill forNumber(int value) {
      return SceneCastSkillConverter.INSTANCE.forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @param other Fallback value in case the value is not known.
     * @return The enum associated with the given numeric wire value, or the fallback value if unknown.
     */
    public static SceneCastSkill forNumberOr(int number, SceneCastSkill other) {
      SceneCastSkill value = forNumber(number);
      return value == null ? other : value;
    }

    enum SceneCastSkillConverter implements EnumConverter<SceneCastSkill> {
      INSTANCE;

      private static final SceneCastSkill[] lookup = new SceneCastSkill[3];

      static {
        lookup[0] = SCENE_CAST_SKILL_NONE;
        lookup[1] = SCENE_CAST_SKILL_PROJECTILE_HIT;
        lookup[2] = SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH;
      }

      @Override
      public final SceneCastSkill forNumber(final int value) {
        if (value >= 0 && value < lookup.length) {
          return lookup[value];
        }
        return null;
      }

      @Override
      public final SceneCastSkill forName(final CharSequence value) {
        if (value.length() == 21) {
          if (ProtoUtil.isEqual("SCENE_CAST_SKILL_NONE", value)) {
            return SCENE_CAST_SKILL_NONE;
          }
        }
        if (value.length() == 31) {
          if (ProtoUtil.isEqual("SCENE_CAST_SKILL_PROJECTILE_HIT", value)) {
            return SCENE_CAST_SKILL_PROJECTILE_HIT;
          }
        }
        if (value.length() == 43) {
          if (ProtoUtil.isEqual("SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH", value)) {
            return SCENE_CAST_SKILL_PROJECTILE_LIFETIME_FINISH;
          }
        }
        return null;
      }
    }
  }
}
