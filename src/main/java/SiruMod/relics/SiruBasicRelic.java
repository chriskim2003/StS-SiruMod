package SiruMod.relics;

import SiruMod.DefaultMod;
import SiruMod.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.unique.MadnessAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.colorless.Madness;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class SiruBasicRelic extends CustomRelic {

    public static final String ID = DefaultMod.makeID("SiruBasicRelic");

    private static final Texture IMG = TextureLoader.getTexture("SiruModResources/images/relics/SiruBasic_Relic.png");
    public SiruBasicRelic() {
        super(ID, IMG, RelicTier.SPECIAL, LandingSound.HEAVY);
    }

    @Override
    public void atTurnStartPostDraw() {
        flash();
        AbstractDungeon.player.useCard(CardLibrary.getCard(Madness.ID), null, 0);
    }

    @Override
    public AbstractRelic makeCopy() { // always override this method to return a new instance of your relic
        return new SiruBasicRelic();
    }
}
