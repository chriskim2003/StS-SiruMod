package SiruMod.relics;

import SiruMod.DefaultMod;
import SiruMod.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.animations.AnimateHopAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class SiruBossVodka extends CustomRelic {
    public static final String ID = DefaultMod.makeID("SiruBossVodka");

    private static final Texture IMG = TextureLoader.getTexture("SiruModResources/images/relics/placeholder_relic.png");
    public SiruBossVodka() {
        super(ID, IMG, RelicTier.BOSS, LandingSound.SOLID);
    }

    @Override
    public int onLoseHpLast(int damageAmount) {
        if(damageAmount > 0) {
            int random = (int) (Math.random() * 100);

            if (random < 13) {
                flash();
                damageAmount = damageAmount * 2;
                AbstractDungeon.actionManager.addToBottom(new AnimateHopAction(AbstractDungeon.player));
            } else if (random < 26) {
                flash();
                damageAmount = damageAmount / 2;
                AbstractDungeon.actionManager.addToBottom(new AnimateHopAction(AbstractDungeon.player));
            } else {
                damageAmount = damageAmount;
            }
        }

        return damageAmount;

    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new SiruBossVodka();
    }

}
