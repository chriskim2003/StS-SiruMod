package SiruMod.powers;

import SiruMod.DefaultMod;
import SiruMod.util.TextureLoader;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;

public class SJ6DebuffPow extends AbstractPower implements CloneablePowerInterface {

    public static final String POW_ID = DefaultMod.makeID("SJ6DebuffPow");

    private static final Texture tex84 = TextureLoader.getTexture("SiruModResources/images/powers/placeholder_power84.png");
    private static final Texture tex32 = TextureLoader.getTexture("SiruModResources/images/powers/placeholder_power32.png");
    private final AbstractCreature source;

    public SJ6DebuffPow(AbstractCreature owner, AbstractCreature source, int amount) {
        this.name = CardCrawlGame.languagePack.getPowerStrings(POW_ID).NAME;
        this.ID = POW_ID;
        this.owner = owner;
        this.source = source;
        this.amount = amount;
        this.priority = 10;
        isTurnBased = true;
        canGoNegative = true;
        this.type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        this.updateDescription();
    }

    public void updateDescription() {
        this.description = CardCrawlGame.languagePack.getPowerStrings(POW_ID).DESCRIPTIONS[0];
        this.type = PowerType.BUFF;
    }

    public void atStartOfTurn() {
        if(amount > 1) {
            this.addToBot(new ApplyPowerAction(owner, source, new SJ6DebuffPow(owner, source, -1), -1));
        } else {
            this.addToBot(new RemoveSpecificPowerAction(owner, source, POW_ID));
            this.addToBot(new ApplyPowerAction(owner, source, new DexterityPower(owner, -1), -12));
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new SJ6DebuffPow(owner, source, amount);
    }
}
