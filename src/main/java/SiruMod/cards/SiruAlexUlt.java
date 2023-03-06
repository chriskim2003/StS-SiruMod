package SiruMod.cards;

import SiruMod.DefaultMod;
import SiruMod.powers.AlexUltPow;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.AnimateOrbAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Plasma;

import java.util.Iterator;

public class SiruAlexUlt extends CustomCard {

    public static final String ID = DefaultMod.makeID("SiruAlexUlt");

    public SiruAlexUlt() {
        super(ID, CardCrawlGame.languagePack.getCardStrings(ID).NAME, "SiruModResources/images/cards/Skill.png", -2, CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION, CardType.SKILL, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.NONE);
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void onChoseThisOption() {
        Iterator<AbstractMonster> monsters = AbstractDungeon.getMonsters().monsters.iterator();
        while(monsters.hasNext()) {
            System.out.println(monsters.hasNext());
            AbstractMonster monster = monsters.next();
            this.addToTop(new ApplyPowerAction(monster, monster, new AlexUltPow(monster, monster, 1), 1));
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        this.onChoseThisOption();
    }

    @Override
    public AbstractCard makeCopy() { return new SiruAlexUlt(); }
}
