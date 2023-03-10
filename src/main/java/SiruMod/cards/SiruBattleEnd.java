package SiruMod.cards;

import SiruMod.DefaultMod;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;

import java.util.Iterator;

public class SiruBattleEnd extends CustomCard {

    public static final String ID = DefaultMod.makeID("SiruBattleEnd");

    public SiruBattleEnd() {
        super(ID, CardCrawlGame.languagePack.getCardStrings(ID).NAME, "SiruModResources/images/cards/Skill.png", -2, CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION, CardType.SKILL, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.NONE);
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        Iterator var1 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        do {
            if (!var1.hasNext()) {
                return true;
            }

            m = (AbstractMonster) var1.next();
            if (m.hasPower("BackAttack")) {
                return false;
            }
        } while (m.type != AbstractMonster.EnemyType.BOSS);

        return false;

    }


    @Override
    public void upgrade() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(new run());
    }

    private static class run extends AbstractGameAction {
        @Override
        public void update() {
            if(!AbstractDungeon.getCurrRoom().isBattleOver) {
                AbstractCreature target = AbstractDungeon.player;
                if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
                    AbstractDungeon.getCurrRoom().smoked = true;
                    this.addToBot(new VFXAction(new SmokeBombEffect(target.hb.cX, target.hb.cY)));
                    AbstractDungeon.player.hideHealthBar();
                    AbstractDungeon.player.isEscaping = true;
                    AbstractDungeon.player.flipHorizontal = !AbstractDungeon.player.flipHorizontal;
                    AbstractDungeon.overlayMenu.endTurnButton.disable();
                    AbstractDungeon.player.escapeTimer = 2.5F;
                }
            }
            this.isDone = true;
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new SiruBattleEnd();
    }
}
