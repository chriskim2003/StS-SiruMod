package SiruMod.cards;

import SiruMod.DefaultMod;
import SiruMod.util.TextureLoader;
import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

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
        keywords.add("SiruMod:SiruBasicCard tooltip");
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }
}
