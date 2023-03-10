package SiruMod.relics;

import SiruMod.DefaultMod;
import SiruMod.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.Madness;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.cards.status.VoidCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class SiruBasicRelic extends CustomRelic {

    public static final String ID = DefaultMod.makeID("SiruBasicRelic");

    private static final Texture IMG = TextureLoader.getTexture("SiruModResources/images/relics/SiruBasic_Relic.png");
    public SiruBasicRelic() {
        super(ID, IMG, RelicTier.SPECIAL, LandingSound.SOLID);
    }

    @Override
    public void atTurnStartPostDraw() {
        flash();
        AbstractCard madness = CardLibrary.getCard(Madness.ID);
        madness.upgrade();
        AbstractDungeon.player.useCard(madness, null, 0);
    }

    @Override
    public void onPlayerEndTurn() {
        this.addToBot(new MakeTempCardInDiscardAction(new Dazed(), 1));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() { // always override this method to return a new instance of your relic
        return new SiruBasicRelic();
    }
}
