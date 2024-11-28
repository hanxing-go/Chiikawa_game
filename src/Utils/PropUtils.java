package Utils;

import JavaBean.GameObj;
import JavaBean.Player.GamePlayer;
import JavaBean.Prop.GameProp;

public class PropUtils {
    public static void getBuff(GameProp gameProp) {
        switch (gameProp.getType()) {
            case 0:
                shitBuff(gameProp);
                break;
            case 1:
                break;
            case 2:
                cookieBuff(gameProp);
                break;
            case 3:
                pajamsBuff(gameProp);
                break;
            case 5:
                wandBuff(gameProp);
                break;
            case 7:
                bookBuff(gameProp);
                break;
            case 8:
                cameraBuff(gameProp);
                break;

            case 11:
                noodlesBuff(gameProp);
                break;
            case 12:
                mushroomBuff(gameProp);
                break;
        }
    }

    private static void bookBuff(GameProp gameProp) {
        if (ObjUtils.flagjiy1 == 0) {
            // 如果还没出现吉伊，那么就添加一个吉伊
        } else {
            for (GamePlayer gamePlayer : ObjUtils.gamePlayers) {
                if (gamePlayer.getType() == 0) {
                    gamePlayer.setDamage(gamePlayer.getDamage() + 1);
                    gamePlayer.setHp(gamePlayer.getMaxHP());
                }
            }
        }
    }

    private static void mushroomBuff(GameProp gameProp) {
        propBuff(gameProp);
        setGamePropXY(gameProp);
    }

    private static void noodlesBuff(GameProp gameProp) {
        propBuff(gameProp);
        setGamePropXY(gameProp);
    }

    private static void cameraBuff(GameProp gameProp) {
        if (ObjUtils.flageight1 == 0) {
            // 如果这个时候还没有小八，那么就添加一个小八
            ObjUtils.flageight1 = 1;
        } else {
            // 给小八增加伤害，回满血
            for (GamePlayer gamePlayer : ObjUtils.gamePlayers) {
                if (gamePlayer.getType() == 1) {
                    gamePlayer.setDamage(gamePlayer.getDamage() + 1);
                    gamePlayer.setHp(gamePlayer.getMaxHP());
                }
            }
        }

        setGamePropXY(gameProp);
    }

    private static void wandBuff(GameProp gameProp) {
        System.out.println("魔杖");
        // 获得魔杖后可以拥有乌萨奇红温技能
        for (GamePlayer gamePlayer : ObjUtils.gamePlayers) {
            if (gamePlayer.getType() == 2){
                System.out.println("增伤");
                gamePlayer.setSkillcount(gamePlayer.getSkillcount() + 1);
                gamePlayer.setDamage(gamePlayer.getDamage() + 1);
                gamePlayer.setHp(gamePlayer.getHp() - 5); //wtm直接让你掉5滴血
            } else if (gamePlayer.getType() == 1) {
                //小八扣血
                gamePlayer.setHp(gamePlayer.getHp() - 5);
            } else if (gamePlayer.getType() == 0) {
                // 吉伊增伤
                gamePlayer.setDamage(gamePlayer.getDamage() + 1);
            }
        }

        setGamePropXY(gameProp);//移动手杖
    }

    private static void pajamsBuff(GameProp gameProp) {
        // 睡衣可以为对应角色增加血量上限
        for (GamePlayer gamePlayer : ObjUtils.gamePlayers) {
            if (gamePlayer.getType() == 1 && gameProp.getUnderImg().equals(ImageUtils.pajamseight)) {
                gamePlayer.setMaxHP(20);
                gamePlayer.setExplodenum(Math.min(2, gamePlayer.getExplodenum() + 1));                      //对角色发射子弹的影响

            } else if (gamePlayer.getType() == 0 && gameProp.getUnderImg().equals(ImageUtils.pajamsjiy)) {
                gamePlayer.setMaxHP(20);
                gamePlayer.setExplodenum(Math.min(2, gamePlayer.getExplodenum() + 1));                      //对角色发射子弹的影响

            } else if (gamePlayer.getType() == 2 && gameProp.getUnderImg().equals((ImageUtils.pajamsUsaqi))){
                gamePlayer.setMaxHP(20);
                gamePlayer.setExplodenum(Math.min(3, gamePlayer.getExplodenum() + 1));                      //对角色发射子弹的影响

            }
        }

        propBuff(gameProp);
        setGamePropXY(gameProp);
    }
    private static void cookieBuff(GameProp gameProp) {
        // 为每一个角色回血
        propBuff(gameProp);
        //移动道具
        setGamePropXY(gameProp);
    }

    private static void propBuff(GameProp gameProp) {
        // 对于每一个道具都一个公共的增益或则建议功能，所以提取出来，特殊的只需要特殊处理即可
        for (GamePlayer gamePlayer: ObjUtils.gamePlayers) {
            gamePlayer.setHp(Math.min(gamePlayer.getMaxHP(), gamePlayer.getHp() + gameProp.getImpacthp()));//对血量的影响
            gamePlayer.setDamage(Math.max(1, gamePlayer.getDamage() + gameProp.getImpactDamage()));     //对角色伤害的影响
        }
    }

    private static void shitBuff(GameProp gameProp) {
        System.out.println("碰到屎");
        propBuff(gameProp);
        gameProp.setImg(ImageUtils.mud);
        gameProp.setType(1);
        gameProp.setX(100);
        gameProp.setY(100);
        gameProp.setSpeed(0);
    }

    private static void setGamePropXY(GameProp gameProp) {
        gameProp.setX(-1200);
    }
}
