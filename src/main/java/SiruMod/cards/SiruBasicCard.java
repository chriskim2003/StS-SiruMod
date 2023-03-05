package SiruMod.cards;

import SiruMod.DefaultMod;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import java.util.Iterator;

public class SiruBasicCard extends CustomCard {

    public static final String ID = DefaultMod.makeID("SiruBasicCard");

    //유기 카드
    //손에 있는 모든 카드를 사용하고 전투를 끝냄
    public SiruBasicCard() {
        super(ID, CardCrawlGame.languagePack.getCardStrings(ID).NAME, "SiruModResources/images/cards/Skill.png", 3, CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION, CardType.POWER, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.SELF);
    }
    @Override
    public void upgrade() {

    }

    @Override
    public void initializeDescription() {
        super.initializeDescription();
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        Iterator<AbstractCard> handsit = AbstractDungeon.player.hand.group.iterator();

        while(handsit.hasNext()) {
            AbstractCard c = (AbstractCard)handsit.next();
            if(c.cardID == "SiruBasicCard") { continue; }
            //this.addToTop(new NewQueueCardAction(c, AbstractDungeon.getCurrRoom().monsters.getRandomMonster(), false, true));
            AbstractDungeon.actionManager.addCardQueueItem(new CardQueueItem(c,true, EnergyPanel.getCurrentEnergy(), true, true), true);
        }

        AbstractDungeon.actionManager.addCardQueueItem(new CardQueueItem(CardLibrary.getCard(SiruBattleEnd.ID), true, EnergyPanel.getCurrentEnergy(), true, true), false);

    }

    @Override
    public AbstractCard makeCopy() {
        return new SiruBasicCard();
    }


}
