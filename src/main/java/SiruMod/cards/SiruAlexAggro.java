package SiruMod.cards;

import SiruMod.DefaultMod;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SiruAlexAggro extends CustomCard {

    public static final String ID = DefaultMod.makeID("SiruAlexAggro");

    public SiruAlexAggro() {
        super(ID, CardCrawlGame.languagePack.getCardStrings(ID).NAME, "SiruModResources/images/cards/Skill.png", -2, CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION, CardType.SKILL, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.NONE);
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void onChoseThisOption() {
        AbstractDungeon.player.addBlock(25);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        this.onChoseThisOption();
    }

    @Override
    public AbstractCard makeCopy() { return new SiruAlexAggro(); }
}
