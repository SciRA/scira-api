package scira.sparql.vocabulary;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

/**
 * Created by SilviuG on 28.11.2017.
 */
public class SCHEMA {
    private static Model MODEL = ModelFactory.createDefaultModel();

    public static final String NS = "http://schema.org/";
    public static final Resource NAMESPACE;
    public static final Property citation;
    public static final Property author;
    public static final Property award;
    public static final Property comment;
    public static final Property commentCount;
    public static final Property contentLocation;
    public static final Property contentRating;
    public static final Property contributor;
    public static final Property copyrightHolder;
    public static final Property copyrightYear;
    public static final Property creator;
    public static final Property dateCreated;
    public static final Property datePublished;
    public static final Property editor;
    public static final Property inLanguage;
    public static final Property isBasedOn;
    public static final Property isPartOf;
    public static final Property keywords;
    public static final Property license;
    public static final Property locationCreated;
    public static final Property mentions;
    public static final Property publication;
    public static final Property publisher;
    public static final Property review;
    public static final Property text;
    public static final Property sponsor;
    public static final Property url;
    public static final Property sameAs;
    public static final Property name;
    public static final Property description;

    public static final Resource URL;
    public static final Resource Text;
    public static final Resource Place;
    public static final Resource Organization;
    public static final Resource Person;
    public static final Resource Thing;
    public static final Resource CreativeWork;
    public static final Resource Article;
    public static final Resource ScholarlyArticle;

    public SCHEMA() {
    }

    public static String getURI() {
        return "http://schema.org/";
    }

    static {
        NAMESPACE = MODEL.createResource("http://schema.org/");
        citation = MODEL.createProperty("http://schema.org/citation");
        author = MODEL.createProperty("http://schema.org/author");
        award = MODEL.createProperty("http://schema.org/award");
        comment = MODEL.createProperty("http://schema.org/comment");
        commentCount = MODEL.createProperty("http://schema.org/commentCount");
        contentLocation = MODEL.createProperty("http://schema.org/contentLocation");
        contentRating = MODEL.createProperty("http://schema.org/contentRating");
        contributor = MODEL.createProperty("http://schema.org/contributor");
        copyrightHolder = MODEL.createProperty("http://schema.org/copyrightHolder");
        copyrightYear = MODEL.createProperty("http://schema.org/copyrightYear");
        creator = MODEL.createProperty("http://schema.org/creator");
        dateCreated = MODEL.createProperty("http://schema.org/dateCreated");
        datePublished = MODEL.createProperty("http://schema.org/datePublished");
        editor = MODEL.createProperty("http://schema.org/editor");
        inLanguage = MODEL.createProperty("http://schema.org/inLanguage");
        isBasedOn = MODEL.createProperty("http://schema.org/isBasedOn");
        isPartOf = MODEL.createProperty("http://schema.org/isPartOf");
        keywords = MODEL.createProperty("http://schema.org/keywords");
        license = MODEL.createProperty("http://schema.org/license");
        locationCreated = MODEL.createProperty("http://schema.org/locationCreated");
        mentions = MODEL.createProperty("http://schema.org/mentions");
        publication = MODEL.createProperty("http://schema.org/publication");
        publisher = MODEL.createProperty("http://schema.org/publisher");
        review = MODEL.createProperty("http://schema.org/review");
        text = MODEL.createProperty("http://schema.org/text");
        sponsor = MODEL.createProperty("http://schema.org/sponsor");
        url = MODEL.createProperty("http://schema.org/url");
        sameAs = MODEL.createProperty("http://schema.org/sameAs");
        name = MODEL.createProperty("http://schema.org/name");
        description = MODEL.createProperty("http://schema.org/description");


        URL = MODEL.createResource("http://schema.org/URL");
        Text = MODEL.createResource("http://schema.org/Text");
        Place = MODEL.createResource("http://schema.org/Place");
        Organization = MODEL.createResource("http://schema.org/Organization");
        Person = MODEL.createResource("http://schema.org/Person");
        Thing = MODEL.createResource("http://schema.org/Thing");
        CreativeWork = MODEL.createResource("http://schema.org/CreativeWork");
        Article = MODEL.createResource("http://schema.org/Article");
        ScholarlyArticle = MODEL.createResource("http://schema.org/ScholarlyArticle");
    }
}
