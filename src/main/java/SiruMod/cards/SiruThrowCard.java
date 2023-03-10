package SiruMod.cards;

import SiruMod.DefaultMod;
import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.screens.select.HandCardSelectScreen;

import java.util.List;
import java.util.function.Consumer;

public class SiruThrowCard extends CustomCard {

    public static final String ID = DefaultMod.makeID("SiruThrowCard");

    public SiruThrowCard() {
        super(ID, CardCrawlGame.languagePack.getCardStrings(ID).NAME, "SiruModResources/images/cards/Skill.png", 2, CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION, CardType.SKILL, CardColor.COLORLESS, CardRarity.RARE, CardTarget.NONE);
        this.exhaust = true;
    }

    @Override
    public void initializeDescription() {
        super.initializeDescription();
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Consumer<List<AbstractCard>> callback = c -> this.addToBot(new DiscardSpecificCardAction(c.get(0)));
        this.addToBot(new SelectCardsInHandAction(1, "카드를 선택해라", callback));
    }

    @Override
    public AbstractCard makeCopy() {
        return new SiruThrowCard();
    }
}
