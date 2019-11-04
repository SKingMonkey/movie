package com.sun.movie.service.recommerder;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于用户的协同过滤推荐
 */
@Service
public class UserBasedService {
    public List<RecommendedItem> userBasedRecommender(int userID, int size) {
        List<RecommendedItem> recommendations = new ArrayList<>();

        try {
            DataModel dataModel = new FileDataModel(new File("/Users/sun/Documents/movie_preference.csv"));
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, dataModel);

            Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(dataModel, neighborhood, similarity));
            recommendations = recommender.recommend(userID, size);
        } catch (IOException | TasteException e) {
            e.printStackTrace();
        }

        return recommendations;
    }
}
