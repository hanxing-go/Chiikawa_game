package Utils;

import JavaBean.Player.GamePlayer;

public class SkillUtils {
    public static void redUsaqi() {
        //如果乌萨奇有红温技能的话，启动红温
        for (GamePlayer gamePlayer : ObjUtils.gamePlayers) {
            if (gamePlayer.getType() == 2 && gamePlayer.getSkillcount() > 0) {
                gamePlayer.setSkillcount(gamePlayer.getSkillcount() - 1);//技能次数减1

            }
        }
    }
}
