package SiruMod.cards;

import SiruMod.DefaultMod;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;

public class SiruAlexWPS extends CustomCard {

    public static final String ID = DefaultMod.makeID("SiruAlexWPS");

    public SiruAlexWPS() {
        super(ID, CardCrawlGame.languagePack.getCardStrings(ID).NAME, "SiruModResources/images/cards/Skill.png", -2, CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION, CardType.SKILL, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.NONE);
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void onChoseThisOption() {
        AbstractPlayer abstractPlayer = AbstractDungeon.player;
        this.addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new BufferPower(abstractPlayer, 1), 1));
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        this.onChoseThisOption();
    }

    @Override
    public AbstractCard makeCopy() {
        return new SiruAlexWPS();
    }
}
