package SiruMod.relics;

import SiruMod.DefaultMod;
import SiruMod.powers.SJ6DebuffPow;
import SiruMod.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;

public class SiruRareSJ6 extends CustomRelic implements ClickableRelic {

    public static final String ID = DefaultMod.makeID("SiruRareSJ6");

    private static final Texture IMG = TextureLoader.getTexture("SiruModResources/images/relics/SiruBasic_Relic.png");
    public SiruRareSJ6() {
        super(ID, IMG, RelicTier.RARE, LandingSound.SOLID);
    }


    //2턴동안 민첩 7이 생깁니다. 이후 민첩이 5 줄어듭니다.
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void onRightClick() {
        this.usedUp();
        AbstractPlayer player = AbstractDungeon.player;
        this.addToBot(new ApplyPowerAction(player, player, new DexterityPower(player, 7)));
        this.addToBot(new ApplyPowerAction(player, player, new SJ6DebuffPow(player, player, 2)));
    }

    @Override
    public void clickUpdate() {
        ClickableRelic.super.clickUpdate();
    }

    @Override
    public boolean hovered() {
        return ClickableRelic.super.hovered();
    }
}
