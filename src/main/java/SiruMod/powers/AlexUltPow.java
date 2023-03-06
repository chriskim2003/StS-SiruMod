package SiruMod.powers;

import SiruMod.DefaultMod;
import SiruMod.util.TextureLoader;
import basemod.abstracts.cardbuilder.actionbuilder.EffectActionBuilder;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.audio.SoundMaster;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;
import com.megacrit.cardcrawl.vfx.combat.OrbFlareEffect;

public class AlexUltPow extends AbstractPower implements CloneablePowerInterface {
    public AbstractCreature source;
    public static final String POW_ID = DefaultMod.makeID("AlexUltPow");

    private static final Texture tex84 = TextureLoader.getTexture("SiruModResources/images/powers/placeholder_power84.png");
    private static final Texture tex32 = TextureLoader.getTexture("SiruModResources/images/powers/placeholder_power32.png");

    public AlexUltPow(AbstractCreature owner, AbstractCreature source, int amount) {
        this.name = CardCrawlGame.languagePack.getPowerStrings(POW_ID).NAME;
        this.ID = POW_ID;
        this.owner = owner;
        this.source = source;
        this.amount = amount;
        this.priority = 10;
        isTurnBased = false;
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
        AbstractDungeon.actionManager.addToBottom(new VFXAction(new LightningEffect(owner.drawX, owner.drawY), 0.0F));
        AbstractDungeon.actionManager.addToBottom(new SFXAction("ORB_PLASMA_EVOKE"));
        AbstractDungeon.actionManager.addToBottom(new DamageAction(owner, new DamageInfo(owner, 3*amount, DamageInfo.DamageType.THORNS)));
    }

    @Override
    public AbstractPower makeCopy() {
        return new AlexUltPow(owner, source, amount);
    }
}
