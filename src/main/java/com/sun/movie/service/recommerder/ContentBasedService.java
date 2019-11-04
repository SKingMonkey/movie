package com.sun.movie.service.recommerder;

import com.sun.movie.dal.model.MahoutModel;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于内容的协同过滤推荐
 */
@Service
public class ContentBasedService {

    @Autowired
    private MahoutModel mahoutModel;

    public List<RecommendedItem> getContentBasedRecommendedItem(long userID, int size) {
        List<RecommendedItem> recommendations = new ArrayList<>();

        try {
            DataModel dataModel = new FileDataModel(new File("/Users/sun/Documents/movie_preference.csv"));
//            DataModel dataModel = mahoutModel.getMahoutModel();
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
            Recommender recommender = new GenericItemBasedRecommender(dataModel, similarity);
            recommendations = recommender.recommend(userID, size);
        } catch (IOException | TasteException e) {
            e.printStackTrace();
        }

        return recommendations;
    }
}
